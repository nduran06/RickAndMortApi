package com.app.rickandmorthy.tool;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class MapperUtil {
	
	private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private MapperUtil() {}

    public static <D, T> D map(final T entity, Class<D> enClass) {
    	
        return modelMapper.map(entity, enClass);
    }

    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
    	
        return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
    }

}
