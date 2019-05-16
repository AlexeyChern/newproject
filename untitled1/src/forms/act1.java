package forms;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class act1 extends AnAction {
    public act1() {

        }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        form2 frm = new form2(e.getProject(), true);
        frm.show();
    }
}