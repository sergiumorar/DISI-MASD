package com.masd.masd.converter;

public interface Converter<MODEL, DTO> {

    MODEL convertDtoToModel(DTO dto);

    DTO convertModelToDto(MODEL model);

}
