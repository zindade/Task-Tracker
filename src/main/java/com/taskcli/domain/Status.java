package main.java.com.taskcli.domain;

import java.nio.ReadOnlyBufferException;

public enum Status {

    enum Level {
        toDo,
        done
    }

    switch(var) {
        case toDo;
            System.out.println("task need to be conclude");
            break;
        case done;
            System.out.printf("task already done");
            break;
        case inprogess;
            System.out.println("task inprogress");
            break;
    }
}
