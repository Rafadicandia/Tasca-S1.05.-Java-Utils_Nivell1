import java.io.Serializable;
import java.util.ArrayList;
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







}
