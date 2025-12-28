package com.project.bookmanagementsystem.mapper;

import com.project.bookmanagementsystem.dto.BookRequest;
import com.project.bookmanagementsystem.dto.BookResponse;
import com.project.bookmanagementsystem.model.BookItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

/**
 * MapStruct mapper for converting between BookItem entity and DTOs.
 * <p>Features:</p>
 * <ul>
 *  <li>Automatic implementation generation at compile time</li>
 *  <li>Field name transformations (camelCase ↔ snake_case)</li>
 *  <li>Type conversions (BigDecimal ↔ float)</li>
 *  <li>Selective field mapping (exclude unsafe fields)</li>
 * </ul>
 */
@Mapper(componentModel = "spring", imports = {BigDecimal.class})
public interface BookMapper {

    /**
     * Convert BookRequest DTO to BookItem entity.
     * <ul>
     *  <li>Ignores client-provided id (server-generated)</li>
     *  <li>Maps publicationDate (camelCase) → publication_date (snake_case)</li>
     *  <li>Ignores available_copies (business logic computes this)</li>
     *  <li>Ignores audit fields (createdAt, updatedAt)</li>
     * </ul>
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "publication_date", source = "publicationDate")
    @Mapping(target = "available_copies", ignore = true)
    @Mapping(target = "price", expression = "java(req.price() == null ? 0.0f : req.price().floatValue())")
    @Mapping(target = "book_id", ignore = true) // or set from external system if needed
    BookItem toEntity(BookRequest req);

    /**
     * Convert BookItem entity to BookResponse DTO.
     * <p>Mapping details:</p>
     * <ul>
     *   <li>Maps the entity's `publication_date` field to the DTO's `publicationDate` field.</li>
     *   <li>Maps the entity's `available_copies` field to the DTO's `availableCopies` field.</li>
     *   <li>Converts the `price` field from a float in the entity to a BigDecimal in the DTO.</li>
     *   <li>Handles null or zero values for the `price` field by setting it to null in the DTO.</li>
     * </ul>
     */
    @Mapping(target = "publicationDate", source = "publication_date")
    @Mapping(target = "availableCopies", source = "available_copies")
    @Mapping(target = "price", expression = "java(item.getPrice() == 0.0f ? null : BigDecimal.valueOf(item.getPrice()))")
    BookResponse toResponse(BookItem item);
}