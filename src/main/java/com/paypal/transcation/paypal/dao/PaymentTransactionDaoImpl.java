package com.paypal.transcation.paypal.dao;

import com.paypal.transcation.paypal.enums.TransactionsType;
import com.paypal.transcation.paypal.model.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class PaymentTransactionDaoImpl implements PaymentTransactionDao {

    @Autowired
    EntityManager entityManager;


    @Override
    public Optional<List<TransactionDetail>> getTransactionDetails(String userId, TransactionsType transactionsType, LocalDateTime dateTime) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TransactionDetail> query = criteriaBuilder.createQuery(TransactionDetail.class);
        Root<TransactionDetail> transactionDetail = query.from(TransactionDetail.class);


        Predicate finalPredicate = null;
        if (Objects.nonNull(userId)) {
            Predicate predicateUserId = criteriaBuilder.equal(transactionDetail.get("phoneNumber"), userId);
            finalPredicate = appendPredicate(criteriaBuilder, finalPredicate, predicateUserId);

        }
        if (Objects.nonNull(transactionsType)) {
            Predicate predicateForTransactionType = criteriaBuilder.equal(transactionDetail.get("type"), transactionsType);
            finalPredicate = appendPredicate(criteriaBuilder, finalPredicate, predicateForTransactionType);
        }

        if (Objects.nonNull(dateTime)) {
            Predicate predicateForTransactionDatetime = criteriaBuilder.equal(transactionDetail.get("transactionDate"), dateTime);
            finalPredicate = appendPredicate(criteriaBuilder, finalPredicate, predicateForTransactionDatetime);
        }
        if (finalPredicate != null) {
            query.where(finalPredicate);
        }
        return Optional.ofNullable(entityManager.createQuery(query).getResultList());
    }

    public Predicate appendPredicate(CriteriaBuilder criteriaBuilder, Predicate oldPredicate, Predicate newPredicate) {
        return (oldPredicate) == null ? criteriaBuilder.and(newPredicate) : criteriaBuilder.and(oldPredicate, newPredicate);

    }
}