package someUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 自定义快捷方式GUI
 *
 * @since 2024-7-4 10:26:57
 */
public class GuiShortcut {
    public GuiShortcut() {
        JFrame frame = new JFrame("S");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 260);
        frame.setLocationRelativeTo(null); //此语句将窗口定位在屏幕的中央
        frame.setLayout(new GridLayout(7, 1));

        JLabel label = new JLabel("自定义快捷方式", SwingConstants.CENTER);
        frame.add(label);

        MyDir[] myDirs = new MyDir[]{
                new MyDir("Python脚本", "/PythonLearn/Normal/utils/pyCmd", Color.GREEN),
                new MyDir("Python笔记", "/PythonLearn/docs", Color.GREEN),
                new MyDir("前端笔记", "/TsLearn/docs", Color.CYAN),
                new MyDir("Java笔记", "/JavaLearn/docs/2023", Color.MAGENTA),
                new MyDir("图片文件", "/MyPicture/public", Color.LIGHT_GRAY),
                new MyDir("图片服务", "/MyPicture/script", Color.LIGHT_GRAY),
        };
        for (MyDir myDir : myDirs) {
            JButton button1 = new JButton(myDir.getBtnNm());
            button1.setBackground(myDir.getColor());
            button1.addActionListener(e -> openDir(myDir.getDirPath()));
            frame.add(button1);
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiShortcut::new);
    }

    private void openDir(String dirPath) {
        if (Desktop.isDesktopSupported()) {
            try {
                // 打开上两级文件夹
                File myFile = new File("../../" + dirPath);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("没有找到文件");
            }
        }
    }
}

class MyDir {
    private final String btnNm, dirPath;
    private final Color color;

    public MyDir(String btnNm, String dirPath, Color color) {
        this.btnNm = btnNm;
        this.dirPath = dirPath;
        this.color = color;
    }

    public String getBtnNm() {
        return btnNm;
    }

    public String getDirPath() {
        return dirPath;
    }

    public Color getColor() {
        return color;
    }
}