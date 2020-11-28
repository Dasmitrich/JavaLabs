package lab17;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Metro {

    public static void main(String[] args) throws IOException {
        new Metro().metrodat();
    }

    MapStations lineStat = new MapStations();
    ArrayList lines = new ArrayList();

    void metrodat() throws IOException {

        Map<String, List> stations = new HashMap<>();
        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines]").maxBodySize(0).get();
        Elements listlines = doc.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");

        for (Element lines : listlines) {
            this.lines.add(new LineMap(lines.attr("data-line"), lines.text()));
        }
        lineStat.lines = lines;

        listlines = doc.select("div.js-metro-stations.t-metrostation-list-table");
        for (Element line : listlines) {
            List list = new ArrayList();
            for (Element st : line.children()) {
                list.add(st.text());
            }
            stations.put(line.attr("data-line"), list);
        }

        lineStat.stations = stations;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String str = gson.toJson(lineStat);


        File file = new File("File.json");
        try (
                FileOutputStream stream = new FileOutputStream(file)) {
            file.createNewFile();
            stream.write(str.getBytes());
        } catch (IOException e) {
            System.out.println("can't write to file");
        }
        str = "";
        try (
                FileInputStream stream = new FileInputStream(file)) {
            while (true) {
                int code = stream.read();

                if (code < 0)
                    break;

                char ch = (char) code;
                str += ch;
            }
            MapStations gotstations = new Gson().fromJson(str, MapStations.class);

            Iterator<Map.Entry<String, List>> it = gotstations.stations.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List> pair = it.next();
                System.out.println("Линия: " + pair.getKey() + " Станций: " + pair.getValue().size());
            }

        } catch (IOException e) {
            System.out.println("error to open");
        }
    }

    class MapStations {
        public ArrayList lines;
        public Map stations;

    }
    class LineMap {
        public String  number, name;
        public LineMap(String number, String name){
            this.name = name;
            this.number = number;
        }
    }
}