package at.userChat;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Chat {
    private User[] user;
    private Scanner scan = new Scanner(new InputStreamReader(System.in));
    private File chatHistory;
    private boolean createFile = false;
    private boolean doStop = false;
    private ArrayList<String> history;


    public Chat(int userCount) {
        this.user = new User [userCount];
        createUser(userCount);
        chooseFile();
    }

    public void createUser(int count){
        for(int i = 1; i < count +1; i++){
            System.out.print("Name User" + i + ": ");
            String name = scan.nextLine();
            User u = new User(i, name);
            this.user[i-1] = u;
        }
    }

    private void chooseFile() {
        System.out.print("Should the chat history be LOAD in a new file? y/n: ");
        String input = scan.nextLine();

        if(input.equals("y")){
            System.out.print("New File name: ");
            String fileName = scan.nextLine();
            this.chatHistory = new File("."+ File.separator + fileName +".txt");
            this.createFile = true;
        } else {

//            Directory wechseln/User kann entscheiden

//            System.out.print("Which directory? (1. this, 2. another): ");
//            int dirInput = scan.nextInt();
//            String dir;

//            if(dirInput == 1){
//                dir = ".\\";
//            } else {
//                System.out.print("Choose a correct directory: ");
//                String userDirectory = scan.next();
//                dir = userDirectory;
//            }

            System.out.print("Choose a File:\n");

            HashMap<Integer, String> filesOfFolder = new HashMap<Integer, String>();

            try{
                int i = 1;
                for(String s: listFilesUsingDirectoryStream(".\\")){
                    System.out.println(i +"  "+ s);
                    filesOfFolder.put(i, s);
                    i++;
                }
            }catch (Exception e){
                System.out.println("Error file writing!");
                e.printStackTrace();
            }



            System.out.print("Choose on number: ");
            Integer fileNumber = scan.nextInt();

            this.chatHistory = new File("."+ File.separator + filesOfFolder.get(fileNumber));
        }
    }

    public Set<String> listFilesUsingDirectoryStream(String dir) throws IOException {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }

    public void chatStart() {

        if(!this.createFile){
            ArrayList<String[]> oldHistory = historyToConsole();
            for(String[] s : oldHistory){
                System.out.print(s[0] + " hat am " + s[2] + " folgende Nachricht an " + s[1]+ " gesendet: \"" + s[3] + "\"\n");
            }

            System.out.println("Should be written in a new file? (y/n)");
            String newFile = scan.next();

            if(newFile.equals("y")){
                System.out.print("Choose a Filename: ");
                String fileName = scan.next();
                String history = readHistory();
                chatHistory = new File("."+ File.separator + fileName + ".txt");

                try(BufferedWriter out = new BufferedWriter(new FileWriter(chatHistory))){
                    out.write(history);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Chat online:");

        do {
            System.out.print("Message from(User ID): ");
            int userID = scan.nextInt();
            System.out.print("Message: ");
            scan.nextLine();
            String msg = scan.nextLine();

            if(msg.equals("-1")){
                doStop = true;

            } else {
                updateChatHistory(userID, msg, new Date());
            }
        } while (doStop == false);
    }





    private ArrayList<String[]> historyToConsole(){
        ArrayList<String[]> oldHistory = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(chatHistory))){
            String line = br.readLine();

            while (line != null) {
                String[] msg = new String[4];
                String[] data = {"(User )(.*?)( hat)", "(user )(.*?)( gesendet)", "(am )(.*?)( folgende)", "(\")(.*?)(\")"};

                int i = 0;

                for (String s : data){
                    Pattern search = Pattern.compile(s);
                    Matcher m = search.matcher(line);

                    while(m.find()){
                        msg[i] = m.group(2);
                    }
                    i++;
                }
                oldHistory.add(msg);

                line = br.readLine();
            }

        } catch (Exception e){
            System.out.println("Error file writing!");
            e.printStackTrace();
        }
        return oldHistory;
    }

    private void updateChatHistory(int userID, String msg, Date date) {
        User currentUser = this.user[userID-1];
        String others = "";
        String history = "";

        for(User u : this.user){
            if( currentUser.getId() != u.getId()){
                if(others == ""){
                    others += u.getName();
                } else {
                    others += ", " + u.getName();
                }
            }
        }

        if(!this.createFile){
           history = readHistory();
        }

        try(BufferedWriter out = new BufferedWriter(new FileWriter(chatHistory))){
            out.write("User " + currentUser.getName() + " hat am " + date.getDate() + " " + date.getTime() +  " folgende Nachricht an user " +  others+ " gesendet: " + "\"" + msg + "\"\n" + history);
            out.close();
            this.createFile = false;
        } catch (Exception e){
            System.out.println("Error file writing!");
            e.printStackTrace();
        }

    }

    private String readHistory() {
        String history= "";

        try(BufferedReader br = new BufferedReader(new FileReader(chatHistory))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            history = sb.toString();

        } catch (Exception e) {
            System.out.println("Error file writing!");
            e.printStackTrace();
        }
        return history;
    }

}
