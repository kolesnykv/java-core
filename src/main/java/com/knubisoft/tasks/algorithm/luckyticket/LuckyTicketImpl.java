package com.knubisoft.tasks.algorithm.luckyticket;

public class LuckyTicketImpl implements LuckyTicket {
    @Override
    public boolean checkIsLuckyTicket(String ticket) {
        if (ticket == null || !ticket.matches("\\d{6,8}")) {
            return false;
        }
        int luckyTicket = Integer.parseInt(ticket);
        if (luckyTicket == palindrome(luckyTicket, 0)) {
            return true;
        } else {
            return false;
        }

    }
    static int palindrome(int number, int temp) {
        if(number == 0){
            return temp;
        }
        temp = (temp * 10) + (number % 10);
        return palindrome(number / 10, temp);
    }
}

