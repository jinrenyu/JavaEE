package com.exam.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.entity.Record;
import com.exam.service.RecordService;
import com.exam.service.impl.RecordServiceImpl;

@WebServlet(name="recordAction", urlPatterns={"/record/*"})
public class RecordAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RecordService recordService = new RecordServiceImpl();
    
    public RecordAction() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String pathInfo = request.getPathInfo();
        List<Record> records = null;
        if ("/main.html".equals(pathInfo)) {
            records = recordService.getAllRecords();
        } else if ("/searchData".equals(pathInfo)) {
            String sCode = request.getParameter("scode");
            String sType = request.getParameter("stype");
            String ssDate = request.getParameter("ssdate");
            String seDate = request.getParameter("sedate");
            String esDate = request.getParameter("esdate");
            String eeDate = request.getParameter("eedate");
            records = recordService.searchByCondition(sCode, sType, ssDate, 
                        seDate, esDate, eeDate);
        } else if ("/add".equals(pathInfo)) {
            request.setAttribute("time", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
            request.getRequestDispatcher("/jsp/addRecord.jsp").forward(request, response);
            return;
        } else if ("/checkout".equals(pathInfo)) {
            String recordId = request.getParameter("id");
            Record record = recordService.getRecordById(recordId);
            request.setAttribute("record", record);
            request.setAttribute("time", new SimpleDateFormat("yyyy-MM-dd HH:mm")
                    .format(record.getStartDate()));
            request.getRequestDispatcher("/jsp/addRecord.jsp").forward(request, response);
            return;
        } else if ("/addRecord".equals(pathInfo)) {
            String roomId = request.getParameter("roomCode");
            String startDate = request.getParameter("startDate");
            String rs = recordService.addRecord(roomId, startDate);
            response.getWriter().print(rs);
            return;
        } else if ("/editRecord".equals(pathInfo)) {
            String recordId = request.getParameter("recordId");
            String rs = recordService.updateRecord(recordId);
            response.getWriter().print(rs);
            return;
        }
        request.setAttribute("records", records);
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
