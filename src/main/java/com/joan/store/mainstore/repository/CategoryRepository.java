/**repositories are always interfaces to the database hence we use interface, also, they have inbuilt
 *  methods like findAll(), findById(), save(), delete() etc.Hence we dontneed to write any
 */
package com.joan.store.mainstore.repository;

import com.joan.store.mainstore.entry.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category, Long> {

}