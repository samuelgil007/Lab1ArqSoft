/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materiaxestudiante;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Samuel
 */
@Local
public interface MateriaxestudianteFacadeLocal {

    void create(Materiaxestudiante materiaxestudiante);

    void edit(Materiaxestudiante materiaxestudiante);

    void remove(Materiaxestudiante materiaxestudiante);

    Materiaxestudiante find(Object id);

    List<Materiaxestudiante> findAll();

    List<Materiaxestudiante> findRange(int[] range);

    int count();
    
}
