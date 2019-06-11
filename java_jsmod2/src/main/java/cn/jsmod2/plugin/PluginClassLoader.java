/*
Jsmod2 is a java-based scpsl server initiated by jsmod2.cn.
It needs to rely on smod2 and proxy. jsmod2 is an open source
free plugin that is released under the GNU license. Please read
the GNU open source license before using the software. To understand
the appropriateness, if infringement, will be handled in accordance
with the law, @Copyright Jsmod2 China,more can see <a href="http://jsmod2.cn">that<a>
 */
package cn.jsmod2.plugin;

import cn.jsmod2.Server;
import cn.jsmod2.ex.MainClassErrorException;
import cn.jsmod2.log.ILogger;
import cn.jsmod2.utils.ConfigGetter;
import cn.jsmod2.utils.PluginFileVO;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PluginClassLoader {

    private List<Plugin> plugins = new ArrayList<>();

    private static PluginClassLoader classLoader;

    static {
        classLoader = new PluginClassLoader();
    }

    private List<File> jarFiles = new ArrayList<>();

    public List<Plugin> loadPlugins(File pluginDir){
        File[] files = pluginDir.listFiles();//all jar files
        loadFiles(files);
        for(File jar:jarFiles){
            plugins.add(loadPlugin(jar));
        }
        return plugins;
    }

    public void loadPlugin(String file){
        loadPlugin(new File(file));
    }

    public Plugin loadPlugin(File jar) {
        try{
            URL url = jar.toURI().toURL();

            URLClassLoader classLoader = new URLClassLoader(new URL[]{url},this.getClass().getClassLoader());

            InputStream in = classLoader.getResourceAsStream("plugin.yml");

            PluginFileVO vo = ConfigGetter.getConfigGetter().toDoPluginSet(in);

            for(Plugin plu:plugins){
                if(plu.getPluginName().equals(vo.getPluginName())){
                    plugins.remove(plu);
                }
            }

            Object plugin = classLoader.loadClass(vo.getMain_class()).newInstance();

            if(plugin instanceof PluginBase){

                Server server = Server.getSender().getServer();

                ILogger logger = server.getLogger();

                Plugin pluginObject = ((PluginBase) plugin);

                pluginObject.init(logger,server,vo.getPluginName(),server.serverfolder,vo.getDescription(),this,new File(server.pluginDir+"/"+vo.getPluginName()),vo.getVersion());

                pluginObject.onLoad();

                pluginObject.setEnabled(true);

                Server.getSender().getServer().getLogger().info("the plugin named:"+vo.getPluginName()+" is loading.. version: "+vo.getVersion());

                return pluginObject;

            }else{

                throw new MainClassErrorException("the main class must be the PluginBase's subclass");

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void loadFiles(File[] files){
        if(files!=null){
            for(File file:files){
                if(file.getName().endsWith(".jar")){
                    jarFiles.add(file);
                }else{
                    loadFiles(file.listFiles());
                }
            }
        }
    }

    public static PluginClassLoader getClassLoader(){
        return classLoader;
    }

    public List<Plugin> getPlugins(){
        return plugins;
    }
}
