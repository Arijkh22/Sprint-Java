<?php

namespace App\Form;

use App\Entity\Utilisateur;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\File;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use App\Validator\Constraints\StartsWithCapital;
use Symfony\Component\Form\Extension\Core\Type\IntegerType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Validator\Constraints\Regex;
use Symfony\Component\Validator\Constraints\GreaterThan;
use Symfony\Component\Validator\Constraints\NotBlank;


class UtilisateurType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom')
            ->add('prenom')
            ->add('password', TextType::class, [
                'constraints' => [
                    new StartsWithCapital(),
                    new Regex([
                        'pattern' => '/\d/',
                        'message' => 'The password must contain at least one number.',
                    ]),
                ],
            ])
            ->add('email')
            ->add('adresse')
            ->add('age')
            ->add('username')
            ->add('photo', FileType::class,
            array(
                'required'=>true,

                'attr' => array(
                    'accept' => "image/jpeg, image/png"
                ),
                'constraints' => [
                    new File([
                        'maxSize' => '2M',
                        'mimeTypes' => [
                            'image/jpeg',
                            'image/png',
                        ],
                        'mimeTypesMessage' => 'Please upload a JPG or PNG',
                        ])
                        ]
                    ))
            // ->add('save',SubmitType::class, [
            //     'attr' => [
            //         'class' => 'btn btn-primary',
            //     ]
            // ])

        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Utilisateur::class,
        ]);
    }
}
