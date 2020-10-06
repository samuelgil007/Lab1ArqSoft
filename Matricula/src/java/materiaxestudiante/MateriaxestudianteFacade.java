/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materiaxestudiante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Samuel
 */
@Stateless
public class MateriaxestudianteFacade extends AbstractFacade<Materiaxestudiante> implements MateriaxestudianteFacadeLocal {

    @PersistenceContext(unitName = "MatriculaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaxestudianteFacade() {
        super(Materiaxestudiante.class);
    }
    
}
