package pl.sda.student;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    private List<Student> studentsList = new ArrayList<>();
    private Path file = Paths.get("Lista Studentów.json");

    public String add(Student x){
        studentsList.add(x);
        return "Dodano nowego Studenta";
        }

        public String deleted(Student x){
        studentsList.remove(x);
        return "Usunięto studneta";
        }

        public String showList(){
        String students = "";
        if(studentsList.size() > 0) {
            for (Student x : studentsList) {
                students += " - " + x.toString() + "\n";
            }
        }else{
            students = "Lista jest pusta";
        }
        return students;
    }
        public String saveFile() {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectMapper mapper =new ObjectMapper();
            try {
                mapper.writeValue(out, studentsList);
                byte[] data = out.toByteArray();

                FileOutputStream file = new FileOutputStream("Lista Studentów.json");
                file.write(data);
                file.close();
                return "Zapisano listę studentów";
            }catch (IOException x){
                return "Błąd zapisu";
            }
        }

        public String readFile(){
            ObjectMapper mapper = new ObjectMapper();
            try{
                InputStream input = new FileInputStream(file.toString());
                Student[] base = mapper.readValue(input, Student[].class);
                studentsList.addAll(Arrays.asList(base));
                return "wczytano z pliku";
            } catch (IOException e) {
                return "dałeś dupy";
            }
        }
}


