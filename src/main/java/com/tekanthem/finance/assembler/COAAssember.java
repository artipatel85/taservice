package com.tekanthem.finance.assembler;

import com.tekanthem.finance.controller.COAController;
import com.tekanthem.finance.entity.COA;
import com.tekanthem.finance.model.COAModel;
import org.springframework.beans.BeanUtils;
import org.springframework.data.rest.webmvc.RepresentationModelAssemblers;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class COAAssember extends RepresentationModelAssemblerSupport<COA, COAModel> {
    public COAAssember() {
        super(COAController.class, COAModel.class);
    }

    @Override
    public COAModel toModel(COA entity) {
        COAModel coaModel = instantiateModel(entity);

        coaModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(COAController.class).get(entity.getAccountCode(), entity.getCompanyCode()))
                .withSelfRel());

        BeanUtils.copyProperties(entity, coaModel);
        return coaModel;
    }

//    @Override
//    public CollectionModel<COAModel> toCollectionModel(Iterable<? extends COA> entities) {
//        CollectionModel<COAModel> coaModels = super.toCollectionModel(entities);
//
//        coaModels.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
//                .methodOn(COAController.class).getAll()).withSelfRel());
//    }
}
