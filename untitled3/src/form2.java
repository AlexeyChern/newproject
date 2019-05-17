import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class form2 extends JFrame {
    private JPanel ContentPane1;
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;

    public form2() {

        button1.addActionListener(ext -> {
            String lang = "ru";

            String textEscaped = textField1.getText();
            String url = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20150402T173446Z.82a90fe78ca2aeaf.a3bd7c7a0f72b260e28f5d92e4f242cf6ba189d3&lang="
                    + lang + "&text=" + textEscaped;
            URLConnection connection = null;
            try {
                try {
                    try {
                        connection = new URL(url).openConnection();

                    } catch (MalformedURLException ex) {
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.printf("No text for translate");
                }
            } catch (IOException e) {
            }
            try {
                InputStream response = connection.getInputStream();
                String json = new java.util.Scanner(response).nextLine();
                int start = json.indexOf("[");
                int end = json.indexOf("]");
                String translated = json.substring(start + 2, end - 1);

                textField2.setText(translated);
            } catch (IOException e) {
                textField2.setText("Я не могу перевести больше 1 слова");
            }


        });


        setContentPane(ContentPane1);
        setVisible(true);
    }


    public JComponent createCenterPanel() {
        return ContentPane1;
    }


}
