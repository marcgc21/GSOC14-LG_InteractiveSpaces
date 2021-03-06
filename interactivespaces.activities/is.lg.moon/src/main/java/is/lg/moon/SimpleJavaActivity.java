package is.lg.moon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import interactivespaces.activity.impl.web.BaseWebActivity;

/**
 * A simple Interactive Spaces Java-based activity.
 */
public class SimpleJavaActivity extends BaseWebActivity {

    @Override
    public void onActivitySetup() {
        getLog().info("Activity is.lg.moon setup");
    }

    @Override
    public void onActivityStartup() {
        getLog().info("Activity is.lg.moon startup");
    }

    @Override
    public void onActivityPostStartup() {
        getLog().info("Activity is.lg.moon post startup");
    }

    @Override
    public void onActivityActivate() {
        getLog().info("Activity is.lg.moon activate");
    }

    @Override
    public void onActivityDeactivate() {
        getLog().info("Activity is.lg.moon deactivate");
    }

    @Override
    public void onActivityPreShutdown() {
        getLog().info("Activity is.lg.moon pre shutdown");
    }

    @Override
    public void onActivityShutdown() {
        getLog().info("Activity is.lg.moon shutdown");
    }

    @Override
    public void onActivityCleanup() {
        getLog().info("Activity is.lg.moon cleanup");
    }
    
    
	@Override
   	public void onWebSocketReceive(String connectionId, Object d) {
   		getLog().info("Got web socket data from connection " + connectionId);
   		
   		@SuppressWarnings("unchecked")
   		Map<String, Object> data = (Map<String, Object>)d;
   		getLog().info(data);
   		data.toString();
   		String key = "message";
   		String value = (String) data.get(key);
   		System.out.println(data);
   		System.out.println(value);
   		
   		try{
       		File file= new File("/tmp", "query.txt");
             	file.createNewFile();

             	FileWriter fw = new FileWriter(file.getAbsoluteFile());
              	BufferedWriter bw = new BufferedWriter(fw);
              	bw.write(value);
              	bw.close();           
       		}
       	catch(IOException e){
       		System.err.println("Impossible to create file " + e);
       	}
   		
   		
   	}
    
}
