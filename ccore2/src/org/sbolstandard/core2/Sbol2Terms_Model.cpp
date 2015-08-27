// Generated from /${project.parent.artifactId}-core2/src/main/java/org/sbolstandard/core2/Sbol2Terms.java
#include <org/sbolstandard/core2/Sbol2Terms_Model.hpp>

#include <java/lang/NullPointerException.hpp>
#include <java/lang/String.hpp>
#include <org/sbolstandard/core2/Sbol2Terms.hpp>
#include <uk/ac/ncl/intbio/core/datatree/NamespaceBinding.hpp>

template<typename T>
static T* npc(T* t)
{
    if(!t) throw new ::java::lang::NullPointerException();
    return t;
}

org::sbolstandard::core2::Sbol2Terms_Model::Sbol2Terms_Model(const ::default_init_tag&)
    : super(*static_cast< ::default_init_tag* >(0))
{
    clinit();
}

org::sbolstandard::core2::Sbol2Terms_Model::Sbol2Terms_Model()
    : Sbol2Terms_Model(*static_cast< ::default_init_tag* >(0))
{
    ctor();
}

javax::xml::namespace_::QName*& org::sbolstandard::core2::Sbol2Terms_Model::Model_()
{
    clinit();
    return Model__;
}
javax::xml::namespace_::QName* org::sbolstandard::core2::Sbol2Terms_Model::Model__;

javax::xml::namespace_::QName*& org::sbolstandard::core2::Sbol2Terms_Model::source()
{
    clinit();
    return source_;
}
javax::xml::namespace_::QName* org::sbolstandard::core2::Sbol2Terms_Model::source_;

javax::xml::namespace_::QName*& org::sbolstandard::core2::Sbol2Terms_Model::language()
{
    clinit();
    return language_;
}
javax::xml::namespace_::QName* org::sbolstandard::core2::Sbol2Terms_Model::language_;

javax::xml::namespace_::QName*& org::sbolstandard::core2::Sbol2Terms_Model::framework()
{
    clinit();
    return framework_;
}
javax::xml::namespace_::QName* org::sbolstandard::core2::Sbol2Terms_Model::framework_;

javax::xml::namespace_::QName*& org::sbolstandard::core2::Sbol2Terms_Model::roles()
{
    clinit();
    return roles_;
}
javax::xml::namespace_::QName* org::sbolstandard::core2::Sbol2Terms_Model::roles_;

extern java::lang::Class *class_(const char16_t *c, int n);

java::lang::Class* org::sbolstandard::core2::Sbol2Terms_Model::class_()
{
    static ::java::lang::Class* c = ::class_(u"org.sbolstandard.core2.Sbol2Terms.Model", 39);
    return c;
}

void org::sbolstandard::core2::Sbol2Terms_Model::clinit()
{
    super::clinit();
    static bool in_cl_init = false;
struct clinit_ {
    clinit_() {
        in_cl_init = true;
        Model__ = npc(Sbol2Terms::sbol2())->withLocalPart(u"Model"_j);
        source_ = npc(Sbol2Terms::sbol2())->withLocalPart(u"source"_j);
        language_ = npc(Sbol2Terms::sbol2())->withLocalPart(u"language"_j);
        framework_ = npc(Sbol2Terms::sbol2())->withLocalPart(u"framework"_j);
        roles_ = npc(Sbol2Terms::sbol2())->withLocalPart(u"role"_j);
    }
};

    if(!in_cl_init) {
        static clinit_ clinit_instance;
    }
}

java::lang::Class* org::sbolstandard::core2::Sbol2Terms_Model::getClass0()
{
    return class_();
}

