package main.graphics;
import java.awt.*;
import java.io.InputStream;

public class FontLoader {
    static String[] fonts = {
            "/fonts/BIZUDMincho-Bold.ttf",
            "/fonts/BIZUDMincho-Regular.ttf",
            "/fonts/SawarabiGothic-Regular.ttf",
            "/fonts/KosugiMaru-Regular.ttf",
            "/fonts/MPLUSRounded1c-Black.ttf",
            "/fonts/MPLUSRounded1c-Bold.ttf",
            "/fonts/MPLUSRounded1c-ExtraBold.ttf",
            "/fonts/MPLUSRounded1c-Light.ttf",
            "/fonts/MPLUSRounded1c-Medium.ttf",
            "/fonts/MPLUSRounded1c-Regular.ttf",
            "/fonts/MPLUSRounded1c-Thin.ttf",
    };

    public static void loadFonts() {
        for (String fontPath : fonts) {
            try (InputStream is = FontLoader.class.getResourceAsStream(fontPath)) {
                Font font = Font.createFont(Font.TRUETYPE_FONT, is);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
