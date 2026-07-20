/**repositories are always interfaces to the database hence we use interface, also, they have inbuilt
 *  methods like findAll(), findById(), save(), delete() etc.Hence we dontneed to write any
 */
package com.joan.store.mainstore.repository;
import com.joan.store.mainstore.entry.Category;
import com.joan.store.mainstore.entry.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByCategory(Category category);


}