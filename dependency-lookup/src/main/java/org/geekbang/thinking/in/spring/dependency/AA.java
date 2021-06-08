package org.geekbang.thinking.in.spring.dependency;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AA {
    public static void main(String[] args) {
        String str = "<8>Apr 22 14:27:08 localhost.localdomain 7|^null|^|^2|^1|^0|^|^|^2021-04-22 14:31:04|^2021-04-22 14:31:04|^null|^null|^null|^c:\\program files (x86)\\common files\\adobe\\acrobat\\activex\\acroiehelper.dll|^null，null|^c:\\program files (x86)\\internet explorer\\iexplore.exe|^Adobe Systems Incorporated|^AcroIEHelper Library|^11.0.0.379|^2|^hurricane618|^2006|^null|^0|^null|^null|^";
       //String str="<8>Apr 22 14:00:57 localhost.localdomain 7|^null|^|^2|^1|^0|^|^|^2021-04-22 14:05:09|^2021-04-22 14:05:09|^WIN-ABK6DUQ6124|^10.10.12.98|^10.10.12.98|^c:\\windows\\syswow64\\msvcr100.dll|^非白名单程序报警，非控制模式执行：通过，白名单校验：未通过|^c:\\program files (x86)\\internet explorer\\iexplore.exe|^Microsoft Corporation|^Microsoft® Visual Studio® 2010|^10.00.40219.1|^2|^hurricane618|^1|^6|^0|^null|^0|^\n";
        String regx ="^[^\\|\\^]*(?:\\|\\^[^\\|\\^]*){7}\\|\\^([1-9][0-9]{3}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})\\|\\^([1-9][0-9]{3}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^([^\\|\\^]*)\\|\\^[^\\|\\^]*";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            System.out.println("生成时间："+matcher.group(1));
            System.out.println("采集时间："+matcher.group(2));
            System.out.println("客户端名称："+matcher.group(3));
            System.out.println("受影响ip："+matcher.group(4));
            System.out.println("源ip："+matcher.group(5));
            System.out.println("路径："+matcher.group(6));
            System.out.println("日志描述："+matcher.group(7));
            System.out.println("父进程："+matcher.group(8));
        }
    }
}
