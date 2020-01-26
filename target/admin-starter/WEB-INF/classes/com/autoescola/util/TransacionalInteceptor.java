package com.autoescola.util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.annotation.Priority;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)

public class TransacionalInteceptor implements Serializable {

    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction et = em.getTransaction();

        boolean criador = false;
        try {
            if (!et.isActive()) {
                et.begin();
                et.rollback();

                et.begin();
                criador = true;
            }
            return context.proceed();

        } catch (Exception e) {
            if (et != null && criador) {
                et.rollback();
            }
            throw e;
        } finally {

            if (et != null && et.isActive() && criador) {
                et.commit();
            }

        }

    }

}
