package until;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;

import entity.ChanPin;
import entity.ChanPinLeiBie;
import entity.DingDanXinXi;
import entity.Users;
import entity.SheBei;
import entity.SheBeiLeiBie;
import entity.XiTongGuanLiYuan;
import entity.YunGongChangGuanLiYuan;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;


/**
 *数据读取增删
 * @author 王瑞翔
 * @date 2021-01-14
 */

//数据读写工具类
public class ShuJuDuXie {
    // 读系统管理员数据
    public static void read1(ArrayList<XiTongGuanLiYuan> xiTongGuanLiYuans) {
        try {
            InputStream is = new FileInputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\系统管理员.xls");
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                HSSFSheet s = wb.getSheetAt(sheet);
                System.out.println(s.getSheetName());
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    XiTongGuanLiYuan user = new XiTongGuanLiYuan();
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }

                    Cell cell = r.getCell(0);
                    cell.setCellType(CellType.STRING);
                    user.setID(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(1);
                    cell.setCellType(CellType.STRING);
                    user.setPassword(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(2);
                    cell.setCellType(CellType.STRING);
                    user.setName(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(3);
                    cell.setCellType(CellType.STRING);
                    user.setPhone(String.valueOf(cell.getStringCellValue()));

                    xiTongGuanLiYuans.add(user);
                }
                System.out.println();
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // 存系统管理员数据
    public static void write1(ArrayList<XiTongGuanLiYuan> xiTongGuanLiYuans) {
        //创建工作簿
        Workbook wb = new HSSFWorkbook();
        //创建 Sheet页
        Sheet sheetA = wb.createSheet();
        int i = 0;
        for (XiTongGuanLiYuan user : xiTongGuanLiYuans) {
            //创建单元行
            Row row = sheetA.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(user.getID());

            cell = row.createCell(1);
            cell.setCellValue(user.getPassword());

            cell = row.createCell(2);
            cell.setCellValue(user.getName());

            cell = row.createCell(3);
            cell.setCellValue(user.getPhone());

            i++;
        }

        try {
            //路径需要存在
            FileOutputStream fos = new FileOutputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\系统管理员.xls");
            wb.write(fos);
            fos.close();
            wb.close();
            System.out.println("写数据结束！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // 读用户管理员数据
    public static void read2(ArrayList<Users> users) {
        try {
            InputStream is = new FileInputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\用户信息.xls");
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                HSSFSheet s = wb.getSheetAt(sheet);
                System.out.println(s.getSheetName());
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    Users user = new Users();
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }

                    Cell cell = r.getCell(0);
                    cell.setCellType(CellType.STRING);
                    user.setID(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(1);
                    cell.setCellType(CellType.STRING);
                    user.setPassword(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(2);
                    cell.setCellType(CellType.STRING);
                    user.setName(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(3);
                    cell.setCellType(CellType.STRING);
                    user.setPhone(String.valueOf(cell.getStringCellValue()));

                    users.add(user);
                }
                System.out.println();
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 存用户管理员数据
    public static void write2(ArrayList<Users> users) {
        //创建工作簿
        Workbook wb = new HSSFWorkbook();
        //创建 Sheet页
        Sheet sheetA = wb.createSheet();
        int i = 0;
        for (Users user : users) {
            //创建单元行
            Row row = sheetA.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(user.getID());

            cell = row.createCell(1);
            cell.setCellValue(user.getPassword());

            cell = row.createCell(2);
            cell.setCellValue(user.getName());

            cell = row.createCell(3);
            cell.setCellValue(user.getPhone());

            i++;
        }

        try {
            //路径需要存在
            FileOutputStream fos = new FileOutputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\用户信息.xls");
            wb.write(fos);
            fos.close();
            wb.close();
            System.out.println("写数据结束！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 读云工厂管理员数据
    public static void read3(ArrayList<YunGongChangGuanLiYuan> ygCguanliyuans) {
        try {
            InputStream is = new FileInputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\工厂管理员.xls");
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                HSSFSheet s = wb.getSheetAt(sheet);
                System.out.println(s.getSheetName());
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    YunGongChangGuanLiYuan factory = new YunGongChangGuanLiYuan();
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }
//                    {"ID":"888","password":"12345","name":"王瑞翔","phone":"11111111111",
//                            "mingcheng":"工厂管理员","jianjie":"0.0","zhuangtai":false}

                    Cell cell = r.getCell(0);
                    cell.setCellType(CellType.STRING);
                    factory.setID(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(1);
                    cell.setCellType(CellType.STRING);
                    factory.setPassword(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(2);
                    cell.setCellType(CellType.STRING);
                    factory.setName(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(3);
                    cell.setCellType(CellType.STRING);
                    factory.setPhone(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(4);
                    cell.setCellType(CellType.STRING);
                    factory.setMingcheng(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(5);
                    cell.setCellType(CellType.STRING);
                    factory.setJianjie(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(6);
                    cell.setCellType(CellType.STRING);
                    factory.setZhuangtai(Boolean.valueOf(cell.getStringCellValue()));

                    ygCguanliyuans.add(factory);
                }
                System.out.println();
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 存云工厂管理员数据
    public static void write3(ArrayList<YunGongChangGuanLiYuan> ygCguanliyuans) {
        //创建工作簿
        Workbook wb = new HSSFWorkbook();
        //创建 Sheet页
        Sheet sheetA = wb.createSheet();
        int i = 0;
        for (YunGongChangGuanLiYuan factory : ygCguanliyuans) {
            //创建单元行
            Row row = sheetA.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(factory.getID());

            cell = row.createCell(1);
            cell.setCellValue(factory.getPassword());

            cell = row.createCell(2);
            cell.setCellValue(factory.getName());

            cell = row.createCell(3);
            cell.setCellValue(factory.getPhone());

            cell = row.createCell(4);
            cell.setCellValue(factory.getMingcheng());

            cell = row.createCell(5);
            cell.setCellValue(factory.getJianjie());

            cell = row.createCell(6);
            cell.setCellValue(factory.isZhuangtai());

            i++;
        }

        try {
            //路径需要存在
            FileOutputStream fos = new FileOutputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\工厂管理员.xls");
            wb.write(fos);
            fos.close();
            wb.close();
            System.out.println("写数据结束！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 读设备数据
    public static void read4(ArrayList<SheBei> sheBeis) {

        try {
            InputStream is = new FileInputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\设备数据.xls");
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                HSSFSheet s = wb.getSheetAt(sheet);
                System.out.println(s.getSheetName());
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    SheBei device = new SheBei();
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }

                    Cell cell = r.getCell(0);
                    cell.setCellType(CellType.STRING);
                    device.setID(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(1);
                    cell.setCellType(CellType.STRING);
                    device.setMingcheng(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(2);
                    cell.setCellType(CellType.STRING);
                    device.setLeixing(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(3);
                    cell.setCellType(CellType.STRING);
                    device.setMiaoshu(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(4);
                    cell.setCellType(CellType.STRING);
                    device.setShebeizhuangtai(Boolean.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(5);
                    cell.setCellType(CellType.STRING);
                    device.setZuyongzhuangtai(Boolean.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(6);
                    cell.setCellType(CellType.STRING);
                    device.setSuoshuGC(String.valueOf(cell.getStringCellValue()));

                    sheBeis.add(device);
                }
                System.out.println();
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 存设备数据
    public static void write4(ArrayList<SheBei> sheBeis) {
        //创建工作簿
        Workbook wb = new HSSFWorkbook();
        //创建 Sheet页
        Sheet sheetA = wb.createSheet();
        int i = 0;
        for (SheBei device : sheBeis) {
            //创建单元行
            Row row = sheetA.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(device.getID());

            cell = row.createCell(1);
            cell.setCellValue(device.getMingcheng());

            cell = row.createCell(2);
            cell.setCellValue(device.getLeixing());

            cell = row.createCell(3);
            cell.setCellValue(device.getMiaoshu());

            cell = row.createCell(4);
            cell.setCellValue(device.isShebeizhuangtai());

            cell = row.createCell(5);
            cell.setCellValue(device.isZuyongzhuangtai());

            cell = row.createCell(6);
            cell.setCellValue(device.getSuoshuGC());

            i++;
        }

        try {
            //路径需要存在
            FileOutputStream fos = new FileOutputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\设备数据.xls");
            wb.write(fos);
            fos.close();
            wb.close();
            System.out.println("写数据结束！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 读产品数据
    public static void read5(ArrayList<ChanPin> chanPins) {
        try {
            InputStream is = new FileInputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\产品数据.xls");
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                HSSFSheet s = wb.getSheetAt(sheet);
                System.out.println(s.getSheetName());
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    ChanPin product = new ChanPin();
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }

                    Cell cell = r.getCell(0);
                    cell.setCellType(CellType.STRING);
                    product.setID(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(1);
                    cell.setCellType(CellType.STRING);
                    product.setMingcheng(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(2);
                    cell.setCellType(CellType.STRING);
                    product.setLeibie(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(3);
                    cell.setCellType(CellType.STRING);
                    product.setGuige(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(4);
                    cell.setCellType(CellType.STRING);
                    product.setMiaoshu(String.valueOf(cell.getStringCellValue()));

                    chanPins.add(product);
                }
                System.out.println();
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 存产品数据
    public static void write5(ArrayList<ChanPin> chanPins) {
        //创建工作簿
        Workbook wb = new HSSFWorkbook();
        //创建 Sheet页
        Sheet sheetA = wb.createSheet();
        int i = 0;
        for (ChanPin chanPin : chanPins) {
            //创建单元行
            Row row = sheetA.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(chanPin.getID());

            cell = row.createCell(1);
            cell.setCellValue(chanPin.getMingcheng());

            cell = row.createCell(2);
            cell.setCellValue(chanPin.getLeibie());

            cell = row.createCell(3);
            cell.setCellValue(chanPin.getGuige());

            cell = row.createCell(4);
            cell.setCellValue(chanPin.getMiaoshu());

           i++;
        }

        try {
            //路径需要存在
            FileOutputStream fos = new FileOutputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\产品数据.xls");
            wb.write(fos);
            fos.close();
            wb.close();
            System.out.println("写数据结束！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

     }

    // 读订单数据
    public static void read6(ArrayList<DingDanXinXi> dingDanXinXis) {
        try {
            InputStream is = new FileInputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\订单信息.xls");
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                HSSFSheet s = wb.getSheetAt(sheet);
                System.out.println(s.getSheetName());
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    DingDanXinXi dingDanXinXi = new DingDanXinXi();
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }

                    Cell cell = r.getCell(0);
                    cell.setCellType(CellType.STRING);
                    dingDanXinXi.setId(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(1);
                    cell.setCellType(CellType.STRING);
                    dingDanXinXi.setMingcheng(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(2);
                    cell.setCellType(CellType.STRING);
                    dingDanXinXi.setShuliang(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(3);
                    cell.setCellType(CellType.STRING);
                    dingDanXinXi.setJaofuriqi(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(4);
                    cell.setCellType(CellType.STRING);
                    dingDanXinXi.setShouhuoren(String.valueOf(cell.getStringCellValue()));

                    cell = r.getCell(5);
                    cell.setCellType(CellType.STRING);
                    dingDanXinXi.setZhuangtai(String.valueOf(cell.getStringCellValue()));

                    dingDanXinXis.add(dingDanXinXi);
                }
                System.out.println();
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 存订单数据
    public static void write6(ArrayList<DingDanXinXi> dingDanXinXis) {
        //创建工作簿
        Workbook wb = new HSSFWorkbook();
        //创建 Sheet页
        Sheet sheetA = wb.createSheet();
        int i = 0;
        for (DingDanXinXi dingDanXinXi : dingDanXinXis) {
            //创建单元行
            Row row = sheetA.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(dingDanXinXi.getId());

            cell = row.createCell(1);
            cell.setCellValue(dingDanXinXi.getMingcheng());

            cell = row.createCell(2);
            cell.setCellValue(dingDanXinXi.getShuliang());

            cell = row.createCell(3);
            cell.setCellValue(dingDanXinXi.getJaofuriqi());

            cell = row.createCell(4);
            cell.setCellValue(dingDanXinXi.getShouhuoren());

            cell = row.createCell(5);
            cell.setCellValue(dingDanXinXi.getZhuangtai());

            i++;
        }

        try {
            //路径需要存在
            FileOutputStream fos = new FileOutputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\订单信息.xls");
            wb.write(fos);
            fos.close();
            wb.close();
            System.out.println("写数据结束！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 读产品类别数据 - ata/leibies1.txt
    public static void read7(ArrayList<ChanPinLeiBie> leibies) {
        try {
            InputStream is = new FileInputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\产品类别信息.xls");
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                HSSFSheet s = wb.getSheetAt(sheet);
                System.out.println(s.getSheetName());
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    ChanPinLeiBie chanPinLeiBie = new ChanPinLeiBie();
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }

                    Cell cell = r.getCell(0);
                    cell.setCellType(CellType.STRING);
                    chanPinLeiBie.setLeibie(String.valueOf(cell.getStringCellValue()));

                    leibies.add(chanPinLeiBie);
                }
                System.out.println();
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 存产品类别数据
    public static void write7(ArrayList<ChanPinLeiBie> leibies) {
        //创建工作簿
        Workbook wb = new HSSFWorkbook();
        //创建 Sheet页
        Sheet sheetA = wb.createSheet();
        int i = 0;
        for (ChanPinLeiBie chanPinLeiBie : leibies) {
            //创建单元行
            Row row = sheetA.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(chanPinLeiBie.getLeibie());

            i++;
        }

        try {
            //路径需要存在
            FileOutputStream fos = new FileOutputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\产品类别信息.xls");
            wb.write(fos);
            fos.close();
            wb.close();
            System.out.println("写数据结束！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 读设备类别数据
    public static void read8(ArrayList<SheBeiLeiBie> leibies) {
        try {
            InputStream is = new FileInputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\设备类别信息.xls");
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            //遍历Sheet页
            for (int sheet = 0; sheet < wb.getNumberOfSheets(); sheet++) {
                HSSFSheet s = wb.getSheetAt(sheet);
                System.out.println(s.getSheetName());
                if (s == null) {
                    continue;
                }
                //遍历row
                for (int row = 0; row <= s.getLastRowNum(); row++) {
                    SheBeiLeiBie sheBeiLeiBie = new SheBeiLeiBie();
                    HSSFRow r = s.getRow(row);
                    if (r == null) {
                        continue;
                    }

                    Cell cell = r.getCell(0);
                    cell.setCellType(CellType.STRING);
                    sheBeiLeiBie.setLeibie(String.valueOf(cell.getStringCellValue()));

                    leibies.add(sheBeiLeiBie);
                }
                System.out.println();
            }
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 存设备类别数据
    public static void write8(ArrayList<SheBeiLeiBie> leibies) {
        //创建工作簿
        Workbook wb = new HSSFWorkbook();
        //创建 Sheet页
        Sheet sheetA = wb.createSheet();
        int i = 0;
        for (SheBeiLeiBie sheBeiLeiBie : leibies) {
            //创建单元行
            Row row = sheetA.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(sheBeiLeiBie.getLeibie());

            i++;
        }

        try {
            //路径需要存在
            FileOutputStream fos = new FileOutputStream("C:\\Users\\35199\\Desktop\\CloudManuFactory_V2\\CloudManuFactory_V2\\data\\设备类别信息.xls");
            wb.write(fos);
            fos.close();
            wb.close();
            System.out.println("写数据结束！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
