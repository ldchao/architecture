package service.serviceimpl.htmlGenerateServiceImpl;

import Entity.Product;
import service.HtmlGenerateService;

import java.io.*;

/**
 * Created by marioquer on 2017/4/10.
 */
public class GoodsInfoGenerate implements HtmlGenerateService {


    /**
     * 商品信息页的生成方法
     */
    public void generate() {
        String readFilePath = "./html/recommendTemplate.html";
        String writeFilePath = "./html/recommend.html"
        write(writeFilePath,read(readFilePath));
    }

    /**
     * 替换静态内容
     * @param line
     * @param changeblock
     * @return
     */
    private String replaceMyLine(String line,String changeblock){

        line=line.replaceAll("###.*?###", changeblock);

        return line;

    }

    /**
     * 读取文件内容
     *
     * @param filePath
     * @return
     */
    public String read(String filePath) {
        BufferedReader br = null;
        String line = null;
        StringBuffer buf = new StringBuffer();

        try {
            // 根据文件路径创建缓冲输入流
            br = new BufferedReader(new FileReader(filePath));

            // 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
            while ((line = br.readLine()) != null) {
                // 此处根据实际需要修改某些行的内容
                if(line.contains("###"))
                {
                    //todo
                }
                buf.append(replaceMyLine(line,"ssss"));
                buf.append(System.getProperty("line.separator"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                }
            }
        }

        return buf.toString();
    }

    /**
     * 将内容回写到文件中
     *
     * @param filePath
     * @param content
     */
    public void write(String filePath, String content) {
        BufferedWriter bw = null;

        try {
            // 根据文件路径创建缓冲输出流
            bw = new BufferedWriter(new FileWriter(filePath));
            // 将内容写入文件中
            bw.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    bw = null;
                }
            }
        }
    }
}
