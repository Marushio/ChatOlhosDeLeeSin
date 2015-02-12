/*
 *:) ;) O.O
 */

package chat;

import java.sql.Date;

/**
 *
 * @author a1320548
 */
public class Mensagem implements Comparable{
    
    private String nick,mensagem;
    private Date date;
    
    


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public int compareTo(Object t) {
        Mensagem msg2 = (Mensagem) t;
        
        if(this.date.compareTo(msg2.getDate())==0)
            return this.nick.compareTo(msg2.getMensagem());
        else return this.date.compareTo(msg2.getDate());
    }
    @Override
    public boolean equals(Object t){
         Mensagem msg2 = (Mensagem) t;
         if(this.date.equals(msg2.getDate()) &&
           this.mensagem.equals(msg2.getMensagem()) &&
           this.nick.equals(msg2.getNick()))
             return true;
        else return false;
    }
    
    
    
}
