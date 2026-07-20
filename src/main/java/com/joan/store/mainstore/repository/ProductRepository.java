/**repositories are always interfaces to the database hence we use interface, also, they have inbuilt
 *  methods like findAll(), findById(), save(), delete() etc.Hence we dontneed to write any
 */
package com.joan.store.mainstore.repository;
import com.joan.store.mainstore.entry.SubCategory;
import com.joan.store.mainstore.entry.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product>findBySubCategory(SubCategory subCategory);

}