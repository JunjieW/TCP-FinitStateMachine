# TCP-FinitStateMachine
TCP-FinitStateMachine

# How to complie:
In the project path, 
    $javac -d ./out/ -cp ./Fsm.jar src/*/*

# How to make a jar file:
In project path,
    $ jar -cvf tcp-fsm.jar -C ./out/ ./out/*

# How to run:
In project path,
    $java -cp "./Fsm.jar;./tcp-fsm.jar" tcpfsm.FSMMain [input_path] 
