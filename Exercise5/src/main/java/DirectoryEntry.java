import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectoryEntry implements Serializable {
    private String name;
    private String type;
    private String lastModified;
    private List<DirectoryEntry> childs;


    public DirectoryEntry(String name, String type, String lastModified){
        this.name = name;
        this.type = type;
        this.lastModified = lastModified;

        if(type.equals('D')) {
            this.childs = new ArrayList<>();
        }
    }

    public void addChild(DirectoryEntry child){
        if(this.childs != null){
            this.childs.add(child);

        }
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String getLastModified(){
        return lastModified;
    }

    public List<DirectoryEntry> getChilds(List<DirectoryEntry> childs) {

        for(DirectoryEntry i:childs){
            childs.get(i);
        }

            

    }

    }







}
