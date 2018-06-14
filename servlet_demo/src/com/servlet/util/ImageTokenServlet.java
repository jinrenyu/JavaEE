package com.servlet.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImageTokenServlet extends HttpServlet {
    private static final long serialVersionUID = -3304697906774325332L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 告诉浏览器, 我的响应是图片的格式(设置验证码图片格式响应)
        response.setContentType("image/jpg");

        // 禁止对应答生成图片的缓存,两句话,一个是HTTP1.0,一个是HTTP1.1
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        // 设置网页过期时间,设置为0表示此页面访问完立刻过期
        response.setDateHeader("Expires", 0);
        // 设置生成的验证码图片大小
        int width = 80, height = 26;
        // 生成图片缓冲区,参数分别为图片大小和颜色风格
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形对象,用来填充缓冲区的画面
        Graphics g = image.getGraphics();
        g.setColor(Color.GREEN);// 设置颜色
        g.fillRect(0, 0, width, height);// 填充矩形区域

        // 改变画笔颜色
        g.setColor(Color.RED);
        // 设置字体,创建字体对象,字体风格,基线对齐,字体大小
        g.setFont(new Font("Time New Roman", Font.ROMAN_BASELINE, 18));
        // 生成随机数字
        String token = generateToken(6);

        // 把验证码放入到会话共享数据范围
        HttpSession session = request.getSession();
        session.setAttribute("token", token);

        g.drawString(token, 10, 16);
        // 加干扰线
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 100, 30);
        g.dispose();// 关闭画笔
        OutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPG", out);// 把内存缓冲中的内容写到指定的流中
        out.close();
    }

    // 生成指定为数的随机数字字符串
    private String generateToken(int length) {
        String[] characters = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        String token = "";
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            int n = r.nextInt(characters.length - 1);
            token += characters[n];
        }
        return token;
    }
}
