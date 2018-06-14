package com.exam.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.entity.enumeration.Status;
import com.exam.service.RoomService;
import com.exam.service.impl.RoomServiceImpl;

@WebServlet(name="roomAction", urlPatterns={"/room/*"})
public class RoomAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomService roomService = new RoomServiceImpl();

    public RoomAction() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        response.setContentType("html/text;utf-8");
        response.setCharacterEncoding("utf-8");
        if ("/getType".equals(pathInfo)) {
            String jsonTypeStr = roomService.getJsonRoomType();
            response.getWriter().print(jsonTypeStr);
        } else if ("/getCode".equals(pathInfo)) {
            String jsonCodeStr = roomService.getJsonRoomCode(
                    new Status[]{Status.AVAILABLE, Status.CHECKOUT});
            response.getWriter().print(jsonCodeStr);
        } else if ("/getSepCode".equals(pathInfo)) {
            String code = request.getParameter("code");
            String rType = roomService.getTypeByCode(code);
            response.getWriter().print(rType);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
