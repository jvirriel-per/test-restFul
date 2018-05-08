package com.jvirriel.testrestful.backend;

import com.jvirriel.testrestful.backend.configuration.be.service.BEService;
import com.jvirriel.testrestful.backend.configuration.restquery.CustomRsqlVisitor;
import com.jvirriel.testrestful.model.Users;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.jvirriel.testrestful.backend.configuration.assessment.predicates.IntegerPredicates.isPositive;
import static com.jvirriel.testrestful.backend.configuration.assessment.predicates.StringPredicates.isNotEmpty;
import static com.jvirriel.testrestful.backend.configuration.search.CriteriaOrderBy.getSortConditions;
import static java.lang.Integer.valueOf;

@Service
public class UsersServices implements BEService<Users, Long> {
    private UsersJpaRepository repository;

    @Autowired
    public UsersServices(UsersJpaRepository repository){
        this.repository = repository;
    }

    @Override
    public void delete(Long id){
        repository.delete(id);
    }

    public Boolean exists(Users entity) {
        Boolean result = Objects.nonNull(entity.getId());

        return !result ? result : repository.exists(entity.getId());
    }

    @Override
    public Boolean exists(Long id) {
        return repository.exists(id);
    }

    @Override
    public List<Users> findAll(String search, String orderBy, String page, String size) {
        Specification<Users> specification = null;
        Sort sort = null;
        PageRequest pageRequest = null;

        List<Users> result;

        Boolean enableSearch = isNotEmpty().test(search),
                enableSort = isNotEmpty().test(orderBy),
                enablePaging = isNotEmpty().test(page) && isNotEmpty().test(size);

        if (enableSearch) {
            Node rootNode = new RSQLParser().parse(search);
            specification = rootNode.accept(new CustomRsqlVisitor<Users>());
        }

        if (enableSort) {
            sort = getSortConditions(orderBy);
        }

        if (enablePaging) {
            Integer pageValue = valueOf(page);
            Integer sizeValue = valueOf(size);

            checkArgument(isPositive().test(pageValue), "Número de página debe ser positivo");
            checkArgument(isPositive().test(sizeValue), "Número de página debe ser positivo");

            pageRequest = enableSort ? new PageRequest(--pageValue, sizeValue, sort) : new PageRequest(--pageValue,
                    sizeValue);
        }

        if (enableSearch && enableSort && enablePaging) {
            result = repository.findAll(specification, pageRequest).getContent();
        } else if (enableSearch && enableSort) {
            result = repository.findAll(specification, sort);
        } else if (enableSearch && enablePaging) {
            result = repository.findAll(specification, pageRequest).getContent();
        } else if (enableSearch) {
            result = repository.findAll(specification);
        } else if (enablePaging) {
            result = repository.findAll(pageRequest).getContent();
        } else if (enableSort) {
            result = repository.findAll(sort);
        } else {
            result = repository.findAll();
        }

        return result;
    }

    @Override
    public Users findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Users save(Users entity) {
        return (entity != null) ? repository.save(entity) : null;
    }

}
