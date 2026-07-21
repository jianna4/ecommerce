package com.joan.store.mainstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CategoryDto is a Data Transfer Object (DTO).
 * It is used to transfer category data between different layers of the application,
 * such as the Controller, Service, and Client.
 *
 * @Data
 * Generates:
 * - Getters and setters for all fields.
 * - toString() method for printing object details of which if missed will return the memory address instead of the actual values.
 * - equals() method for comparing the contents of two objects.
 * - hashCode() method for generating a hash value used by collections such as HashMap and HashSet.
 * - RequiredArgsConstructor for required fields (final fields or fields annotated with @NonNull).
 *
 * @NoArgsConstructor
 * Generates a constructor with no parameters.
 * used by Spring and Jackson, which create
 * an empty object first and then populate its fields.used mostly for user inputs and has no args coz we would
 * liek to use it on mmultiple requests that sometimes have or lack other fields
 *
 * @AllArgsConstructor
 * Generates a constructor that accepts all fields as parameters.
 * This is useful when creating a fully initialized object, especially during
 * testing or when manually creating DTO objects.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private String name;
    private String description;

}