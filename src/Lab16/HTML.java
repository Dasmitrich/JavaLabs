package Lab16;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class HTML {

        static public String GetUrl(Element el){
            String src = el.absUrl("src");
            return src;
        }
        static public void FindImages(String src){

            String strImageName = src.substring( src.lastIndexOf("/") + 1 );
            try {
                if (src!="") {


                    if (src.charAt(0) == 'h' && (src.contains(".png") || src.contains(".jpeg") || src.contains(".jpg"))) {

                        URL urlImage = new URL(src);
                        InputStream in = urlImage.openStream();

                        byte[] buffer = new byte[4096];
                        int n = -1;

                        System.out.println(strImageName);


                        OutputStream os = new FileOutputStream(System.getProperty("user.dir") + "\\images" + "/" + strImageName);
                        while ((n = in.read(buffer)) != -1) {
                            os.write(buffer, 0, n);
                        }
                        os.close();


                    }

                }
            }
            catch (MalformedURLException | FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) throws IOException {
            new File(System.getProperty("user.dir") + "\\images").mkdir();
            Document doc = Jsoup.connect("https://www.mirea.ru").get();
            Elements img = doc.getElementsByTag("img");


            for (Element el : img) {

                FindImages( GetUrl(el));

            }

        }
}
