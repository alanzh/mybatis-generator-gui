${copyright}

package ${modulePackage}.service;

import ${modulePackage}.utils.SearchCondition;

/**
 * @author ${authName}
 * @version ${.now?date}
 */
 
public interface BaseService<T> {

	Object createEntryApi(T entry);

	Object deleteEntryApi(T entry);

	Object updateEntryApi(T entry);

	Object searchApi(SearchCondition<T> searchCondition);

	Object searchKeywordApi(SearchCondition<T> searchCondition);

}