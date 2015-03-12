/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;




import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class Reminder {
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
        }
    }

  //  public static void main(String args[]) {
  //      new Reminder(5);
 //       System.out.println("Task scheduled.");
  //  }
}

 /*   Quando você rodar o exemplo, vai ver:

Task scheduled.
(depois de 5 segundos)
Time's up!

    O programa ilustra o uso de um "Timer Thread" para executar uma tarefa
        Implementamos um subclasse de TimerTask e especificamos o que fazer no método run()
        Criamos um thread através da instanciação de Timer
            Está claro para você que deve haver um segundo thread em Timer? O que ocorreria se usássemos Thread.sleep(5000) diretamente?
        Instanciamos o TimerTask (new RemindTask())
        Escalonamos a execução da tarefa com o método schedule
            O método schedule faz thread.sleep(5000) em outro thread
        Também podemos executar a tarefa num momento específico:

    //Get the Date corresponding to 11:01:00 pm today.
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 1);
    calendar.set(Calendar.SECOND, 0);
    Date time = calendar.getTime();

    timer = new Timer();
    timer.schedule(new RemindTask(), time);

Parando Timer Threads

    Normalmente, um programa executa enquanto os threads estiverem executando
    Há 4 formas de terminar um Timer thread:
        timer.cancel()
        Faça com que o Timer thread seja um "daemon" criando o timer assim: new Timer(true)
            Um "daemon" é algo que roda como serviço: quando não há mais quem possa usar o serviço, o próprio serviço pode morrer
            Se apenas threads do tipo daemon estiver no ar, o programa termina
        Após a execução das tarefas do Timer thread, remova todas as referências ao timer
        Chame o método System.exit()
            O programa inteiro, com todos seus threads termina
    O programa acima usa a primeira forma de terminar o thread
        Fazer com que o thread seja um daemon thread não funcionaria (por quê?)
    Às vezes, o programa não consegue terminar por causa de outros threads (além dos Timer threads)
        Exemplo: se usar AWT, nem que seja para beepar, AWT vai criar um thread (não daemon) e manter o programa vivo
        O exemplo abaixo precisa de System.exit() para o programa terminar

public class ReminderBeep {
    ...
    public ReminderBeep(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }
    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            toolkit.beep();
            //timer.cancel(); // Not necessary because
                              // we call System.exit
            System.exit(0);   // Stops the AWT thread
                              // (and everything else)
        }
    }
    ...
}

Execução repetida de uma tarefa

    No exemplo abaixo, a tarefa é repetida 1 vez por segundo

public class AnnoyingBeep {
    Toolkit toolkit;
    Timer timer;

    public AnnoyingBeep() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(),
                       0,        //initial delay
                       1*1000);  //subsequent rate
    }

    class RemindTask extends TimerTask {
        int numWarningBeeps = 3;
        public void run() {
            if (numWarningBeeps > 0) {
                toolkit.beep();
                System.out.println("Beep!");
                numWarningBeeps--;
            } else {
                toolkit.beep(); 
                System.out.println("Time's up!");
                //timer.cancel(); // Not necessary because
                                  // we call System.exit
                System.exit(0);   // Stops the AWT thread 
                                  // (and everything else)
            }
        }
    }
    ...
}

    A saída deve ser assim:

Task scheduled.
Beep!      
Beep!      (one second after the first beep)
Beep!      (one second after the second beep)
Time's up! (one second after the third beep)

    Os métodos schedule que podem ser chamados para execução repetida são os seguintes:

    schedule(TimerTask task, long delay, long period)
    schedule(TimerTask task, Date time, long period)
    scheduleAtFixedRate(TimerTask task, long delay, long period)
    scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 

    Nos métodos acima:
        schedule(...) usam delays fixos e o periodo pode portanto ser maior que o pedido
        scheduleAtFixedRate(...) usam delays variáveis de forma a manter os periodos fixos

programa
*/