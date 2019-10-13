package com.enjoy.Executor;

import com.enjoy.config.MapperStament;

import java.util.List;

public interface Executor<E> {

    List<E> query(MapperStament mapperStament, Object paramter);
}
