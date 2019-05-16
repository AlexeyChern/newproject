package forms;

import javax.swing.*;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.project.Project;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class form2 extends DialogWrapper {


    private JTextField textField1;
    private JPanel contentPane;
    private JTextField textField2;
    private JButton trButton;

    public form2(@Nullable Project project, boolean canBeParent) {
        super(project, canBeParent);
        init();
        setTitle("MyPlugin");
        trButton.addActionListener(ext -> {
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





    }



    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return contentPane;
    }
}
