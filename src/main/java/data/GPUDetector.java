package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GPUDetector {
    public static String getGPU(){
        try{
            String filePath="src/main/resources/utils/GPUname.txt";
            ProcessBuilder pb=new ProcessBuilder("cmd.exe", "/c", "dxdiag", "/t", filePath);
            //System.out.println("Executing dxdiag command");
            Process p=pb.start();
            p.waitFor();

            BufferedReader br=new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println(String.format("Printing %1$1s info", filePath));
            while((line=br.readLine())!=null){
                if(line.trim().startsWith("Card name:")){
                    return line.trim().substring(10);
                }
            }
        }catch(IOException | InterruptedException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
