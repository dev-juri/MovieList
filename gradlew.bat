����   2 � %com/oluwafemi/palmfarm/SignUpActivity  (androidx/appcompat/app/AppCompatActivity  binding :Lcom/oluwafemi/palmfarm/databinding/ActivitySignUpBinding; 	viewModel 3Lcom/oluwafemi/palmfarm/viewmodels/SignUpViewModel; onCreate (Landroid/os/Bundle;)V $Lorg/jetbrains/annotations/Nullable; 	 

   android/app/Activity   $androidx/databinding/DataBindingUtil  setContentView ?(Landroid/app/Activity;I)Landroidx/databinding/ViewDataBinding;  
   4DataBindingUtil.setConte….layout.activity_sign_up)  kotlin/jvm/internal/Intrinsics  checkExpressionValueIsNotNull '(Ljava/lang/Object;Ljava/lang/String;)V  
   8com/oluwafemi/palmfarm/databinding/ActivitySignUpBinding   	  ! com/oluwafemi/palmfarm/db/DB # 	Companion (Lcom/oluwafemi/palmfarm/db/DB$Companion; % &	 $ ' getApplication ()Landroid/app/Application; ) *
  + application - android/content/Context / &com/oluwafemi/palmfarm/db/DB$Companion 1 getInstance 9(Landroid/content/Context;)Lcom/oluwafemi/palmfarm/db/DB; 3 4
 2 5 getDbDAO #()Lcom/oluwafemi/palmfarm/db/DbDAO; 7 8
 $ 9 &com/oluwafemi/palmfarm/db/DBRepository ; <init> $(Lcom/oluwafemi/palmfarm/db/DbDAO;)V = >
 < ? :com/oluwafemi/palmfarm/viewmodelfactories/ViewModelFactory A +(Lcom/oluwafemi/palmfarm/db/DBRepository;)V = C
 B D $androidx/lifecycle/ViewModelProvider F &androidx/lifecycle/ViewModelStoreOwner H ,androidx/lifecycle/ViewModelProvider$Factory J Y(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V = L
 G M 1com/oluwafemi/palmfarm/viewmodels/SignUpViewModel O get 1(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel; Q R
 G S 4ViewModelProvider(this, …nUpViewModel::class.java) U  	  W  )throwUninitializedPropertyAccessException (Ljava/lang/String;)V Z [
  \ !androidx/lifecycle/LifecycleOwner ^ setLifecycleOwner &(Landroidx/lifecycle/LifecycleOwner;)V ` a
   b java/lang/String d Farmer f Buyer h  kotlin/collections/CollectionsKt j listOf %([Ljava/lang/Object;)Ljava/util/List; l m
 k n android/widget/ArrayAdapter p d -(Landroid/content/Context;ILjava/util/List;)V = s
 q t regType 7Lcom/google/android/material/textfield/Te