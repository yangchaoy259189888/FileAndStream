package com.mec.about_file.core;

import java.net.ServerSocket;

/**
 * @ClassName: FileReceiveServer
 * @Description:
 * @Author:
 * @Date: 2018/11/21 0:28
 * @Version: V1.0
 **/
public class FileReceiveServer {
    private ServerSocket serverSocket;
    private int port;

    public FileReceiveServer() {
    }

    public FileReceiveServer(int port) {
        this.port = port;
    }
}
