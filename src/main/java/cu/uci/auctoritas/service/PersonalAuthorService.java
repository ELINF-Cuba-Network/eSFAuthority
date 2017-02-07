package cu.uci.auctoritas.service;

import cu.uci.auctoritas.domain.PersonalAuthor;
import cu.uci.auctoritas.repository.PersonalAuthorRepository;
import cu.uci.auctoritas.source.DatasourceJDBCResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonalAuthorService {

    @Autowired
    private DatasourceService datasourceService;

    public List<PersonalAuthor> getPersonalAuthor(String name, String lastname, Integer start, Integer limit){
        List<PersonalAuthor> personalAuthors= datasourceService.getEntities(name, lastname, PersonalAuthor.class);
        List<PersonalAuthor> finalList= new ArrayList<>();

        if ((null == start) || (start==0)){
            start=new Integer(1);
        }
        if ((null != limit) && (limit > personalAuthors.size())) {
            limit = personalAuthors.size();
        }
        if ((start>personalAuthors.size())&&(personalAuthors.size()!=0)){
            PersonalAuthor pa = new PersonalAuthor();
            pa.setName("ERROR, the start parameter exceeds the size of the list");
            pa.setUri("ERROR, the start parameter exceeds the size of the list");
            pa.setAuthority("ERROR, the start parameter exceeds the size of the list");
            pa.setLastname("ERROR, the start parameter exceeds the size of the list");
            finalList.add(pa);
            return finalList;
        }
        if (((null != name) &&( !name.isEmpty()) && (name.length() < 2)) || ((null != lastname) && (!lastname.isEmpty()) && (lastname.length() < 2))){
            PersonalAuthor pa = new PersonalAuthor();
            pa.setName("ERROR, Name and Lastname has to be more than one character");
            pa.setUri("ERROR, Name and Lastname has to be more than one character");
            pa.setAuthority("ERROR, Name and Lastname has to be more than one character");
            pa.setLastname("ERROR, Name and Lastname has to be more than one character");
            finalList.add(pa);
            return finalList;
        }
        if (null != limit) {
            while (limit != 0) {//start debe comenzar en 1
                finalList.add(personalAuthors.get(start - 1));
                limit--;
                start++;
            }
        }else return personalAuthors;
        return finalList;
    }

}
