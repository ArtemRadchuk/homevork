package handler;

import dao.DBConnection;
import domain.Voter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    static HashMap<Voter, Integer> voters = new HashMap<>();
    Voter voter;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter") && voter == null) {

                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
            } else if (qName.equals("visit") && voter != null) {
                int count = voters.getOrDefault(voter, 0);
                voters.put(voter, count + 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            voter = null;
        }
    }

    public static StringBuilder getData() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO voter_count(name, birthDate, `count`) VALUES");
        for (Voter voter : voters.keySet()) {
            if (query.length() == 56){
                query.append("('" + voter.getName() + "', '" + birthDayFormat.format(voter.getBirthDay()) +
                        "', '" + voters.get(voter) + "')");
            }else{
                query.append(", ('" + voter.getName() + "', '" + birthDayFormat.format(voter.getBirthDay()) +
                        "', '" + voters.get(voter) + "')");
            }
            if (query.length() > 50000){
                DBConnection.insertData(query);
                query = new StringBuilder();
                query.append("INSERT INTO voter_count(name, birthDate, `count`) VALUES");
            }
        }
        DBConnection.insertData(query);
        return  query;
    }

    public void printDuplicatedVoters() {
        for (Voter voter : voters.keySet()) {
            int count = voters.get(voter);
            if (count > 1) {
                System.out.println(voter.toString() + " - " + count);
            }
        }
    }
}