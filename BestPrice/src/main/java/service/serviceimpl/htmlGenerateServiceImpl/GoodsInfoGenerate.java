package service.serviceimpl.htmlGenerateServiceImpl;

import Entity.Product;
import controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import service.GetHotGoodsService;
import service.HtmlGenerateService;
import service.serviceimpl.GetHotGoodsServiceImpl;
import vo.GoodVO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marioquer on 2017/4/10.
 */
public class GoodsInfoGenerate implements HtmlGenerateService {

    GetHotGoodsService getHotGoodsService=new GetHotGoodsServiceImpl();
    private List<GoodVO> goodVOList = new ArrayList<GoodVO>();
    private int googId=0;
    /**
     * 商品信息页的生成方法
     */
    public void generate() {
        System.out.println("ggg1");
        String path=MainController.getServletContextPath();
        if(path==null) return;
        String readFilePath = path+"html/recommendTemplate.html";
        String writeFilePath = path+"html/recommend.html";
        System.out.println("ggg2");
        goodVOList= getHotGoodsService.getHotGoods();
        System.out.println("gg3");
        googId = 0;
        System.out.println("ggg4");
        System.out.println(readFilePath);
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
        System.out.println(filePath);
        try {
            // 根据文件路径创建缓冲输入流
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
            System.out.println(filePath);
            // 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
            while ((line = br.readLine()) != null) {
                // 此处根据实际需要修改某些行的内容
                System.out.println(line);
                if(line.contains("###商品名###"))
                {
                    buf.append(replaceMyLine(line,goodVOList.get(googId).getProduct_name()));
                    buf.append(System.getProperty("line.separator"));
                }
                else if(line.contains("###商家名称###"))
                {
                    buf.append(replaceMyLine(line,goodVOList.get(googId).getSeller_name()));
                    buf.append(System.getProperty("line.separator"));
                }
                else if(line.contains("###价格###"))
                {
                    buf.append(replaceMyLine(line,goodVOList.get(googId).getPrice()+""));
                    buf.append(System.getProperty("line.separator"));
                }
                else if(line.contains("###购买链接###"))
                {
                    buf.append(replaceMyLine(line,goodVOList.get(googId).getLink()));
                    buf.append(System.getProperty("line.separator"));
                    googId++;
                }
                else
                {
                    buf.append(line);
                    buf.append(System.getProperty("line.separator"));
                }
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
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"));
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
