package com.hibernateDb.hbdb.Util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public interface IdGenerator extends IdentifierGenerator {

    public Serializable generate(SharedSessionContractImplementor session, Object object);
}
