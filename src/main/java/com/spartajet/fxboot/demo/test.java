package com.spartajet.fxboot.demo;
import com.spartajet.fxboot.demo.services.DealFileServices;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) throws Exception {
        String filename = "/Users/liangjinsi/Documents/梁子庆/梁子庆/广州/【前端开发工程师_广州】罗石焕 8年.docx";
        DealFileServices fileServices = new DealFileServices();
        String result = fileServices.readWord(filename);
        System.out.println(result);
        String phone = fileServices.extractPhone(result);
        System.out.println(phone);
        System.out.println(fileServices.extractEmail(result));
        String regex = "((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))-\\d{4}-\\d{4}";
        Pattern emailPattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(result);
////        List<String> email = new ArrayList<String>();
        if (matcher.find()) {
            String rr = matcher.group(0);
            System.out.println(rr.replaceAll("-",""));
            System.out.println(matcher.group(0));
        }
        }
//    }
//    public void testReadByDoc(String path) throws Exception {
//        InputStream is = new FileInputStream(path);
//        HWPFDocument doc = new HWPFDocument(is);
//        //输出书签信息
////        this.printInfo(doc.getBookmarks());
//        //输出文本
//        Range range = doc.getRange();
//        String dd = this.printInfo(range);
//        System.out.println("doc:"+dd);
//        //把当前HWPFDocument写到输出流中
////        doc.write(new FileOutputStream(filename));
//        is.close();
//    }
//    /**
//     * 输出Range
//     * @param range
//     */
//    private String printInfo(Range range) {
//        //获取段落数
//        StringBuilder sb = new StringBuilder();
//        int paraNum = range.numParagraphs();
//        System.out.println(paraNum);
//        for (int i=0; i<paraNum; i++) {
//            String par = range.getParagraph(i).text();
//            System.out.println("段落" + (i+1) + "：" + par);
//            sb.append(par);
//        }
//        System.out.println(sb.length());
//        for (int i =0;i<sb.length();i++){
////            System.out.println(sb.ge);
//        }
//        System.out.println(sb.toString());
//        return sb.toString();
//    }
}
