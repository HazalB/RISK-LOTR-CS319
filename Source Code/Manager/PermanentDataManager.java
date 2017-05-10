package Manager;

import GameMemory.*;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Mirac Vuslat Basaran on 10-May-17.
 */
public class PermanentDataManager extends Manager {

    public PermanentDataManager(Game game){
        super(game);
    }

    public ArrayList<Province> getProvinceInfo() throws IOException{
        String content;
        ArrayList<Province> provinces = new ArrayList<Province>();

        content = new String(Files.readAllBytes(Paths.get("provincelist.txt")));

        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i++){
            Province prov = new Province();
            prov.setId(i);
            provinces.add(prov);
        }
        for(int i = 0; i < lines.length; i++){
            String[] line = lines[i].split(" ");
            for(int j = 0; j < line.length; j++){
                if(j == 0){;
                }
                else{
                    if(Integer.parseInt(line[j]) >= 5){
                        provinces.get(i).getNeighboringProvinceList().add(Integer.parseInt(line[j]) - 2);
                    }
                    else{
                        provinces.get(i).getNeighboringProvinceList().add(Integer.parseInt(line[j]) - 1);
                    }
                }
            }
        }

        return provinces;
    }

    public ArrayList<Area> getAreaInfo(){
        ArrayList<Area> areas = new ArrayList<Area>();

        String content = "54-55-56-57-58-59\tMordor\n" +
                "44-45-46-47-48-49-50-51-52-53\tGondor\n" +
                "37-38-39-40-41-42-43\tRohan\n" +
                "1-2-3-4-5-6-7-8-9-10-11-12-13-14-15-16-17-18-19\tElves\n" +
                "29-30-31-32-33-34-35-36\tDwarwes\n" +
                "61-62-63-64-65-66\tHarad\n" +
                "20-21-22-23-24-25-26-27-28\tIsengard";
        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i++){
            String[] line = lines[i].split("\t");
            String[] provinces = line[0].split("-");
            String name = line[1];
            Bonus bonus = new Bonus();
            bonus.setIncomeBonus(3);
            Area area = new Area(bonus);
            area.setId(i);
            area.setName(name);
            area.setOwner(null);
            ArrayList<Integer> ids = new ArrayList<Integer>();
            for(int j = 0; j < provinces.length; j++){
                if(Integer.parseInt(provinces[j]) >= 5){
                    ids.add(Integer.parseInt(provinces[j]) - 2);
                }
                else{
                    ids.add(Integer.parseInt(provinces[j]) - 1);
                }
            }
            area.setProvinceIds(ids);
            areas.add(area);
        }
        return areas;
    }
}
