package ReadMissionFile;

import Communicator.DroneCommunicator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJSON extends ReadMissionFile {
//    static String json = "";

    @Override
    public void readFile(DroneCommunicator droneCommunicator) throws IOException {
//        System.out.print(json);
        try{
            // code that may throw exception
            BufferedReader br = new BufferedReader(new FileReader("src/testJSON.json"));
            String json = br.readLine();
            JSONObject obj = new JSONObject(json);
            String pageName = obj.getJSONObject("pageInfo").getString("pageName");
            System.out.println(pageName);
//            JSONArray arr = obj.getJSONArray("posts");
//            for (int i = 0; i < arr.length(); i++) {
//                String post_id = arr.getJSONObject(i).getString("post_id");
//                System.out.println(post_id);
//            }
        }catch(org.json.JSONException e){
            // how you handle the exception
             e.printStackTrace();
        }
    }
}