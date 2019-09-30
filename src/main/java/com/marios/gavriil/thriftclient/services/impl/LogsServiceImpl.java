package com.marios.gavriil.thriftclient.services.impl;

import com.marios.gavriil.thriftclient.entities.LogsDTO;
import com.marios.gavriil.thriftclient.services.LogsService;
import com.marios.gavriil.thriftclient.utils.Constants;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.marios.gavriil.thriftclient.utils.Constants.*;

import java.util.Random;

@Service
public class LogsServiceImpl {

    private Logger logger = LoggerFactory.getLogger(LogsService.class);


    @Scheduled(fixedDelay = 1000L)
    public void logSomeStuff(){

        LogsDTO logsDTO = new LogsDTO();
        String level = LogLevel.getRandomLevel().toString();

        switch (level) {
            case "DEBUG":
                logsDTO.setCode((byte)1);
                logsDTO.setDatetime("dateTime");
                logsDTO.setMessage("This is a Debug log...");
                logsDTO.setLevel(level);
                break;
            case "INFO":
                logsDTO.setCode((byte)1);
                logsDTO.setDatetime("dateTime");
                logsDTO.setMessage("This is a Info log...");
                logsDTO.setLevel(level);
                break;
            case "WARN":
                logsDTO.setCode((byte)1);
                logsDTO.setDatetime("dateTime");
                logsDTO.setMessage("This is a Warn log...");
                logsDTO.setLevel(level);
                break;
            case "ERROR":
                logsDTO.setCode((byte)1);
                logsDTO.setDatetime("dateTime");
                logsDTO.setMessage("This is an Error log...");
                logsDTO.setLevel(level);
                break;
        }

        sendLog(logsDTO);

    }

    private void sendLog(LogsDTO logsDTO) {
        try {
            TTransport tTransport;

            tTransport = new TSocket("localhost",8081);
            tTransport.open();

            TProtocol tProtocol = new TBinaryProtocol(tTransport);
            LogsService.Client client = new LogsService.Client(tProtocol);

            logger.info("Start transmitting log...");

            client.sendLog(logsDTO);

            logger.info("Finished transmitting ...");

            tTransport.close();
        }catch (TTransportException e){
            e.printStackTrace();
        }catch (TException ex){
            ex.printStackTrace();
        }
    }

}
