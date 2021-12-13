import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { User } from '../_models';
import { UserService } from '../_services';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-pos',
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.css']
})
export class PosComponent implements OnInit {
  loading = false;
  users: User[];
  selected:string;
 
  qty:number[]=[1,1];
  itemcost:number[]=[25.0,15.0];
  cost:number[]=[25.0,15.0]
  finalcost:number=40.0
  tax:number=40.0*2/100
  subtotal:number=this.finalcost+this.tax
  signupForm: FormGroup=new FormGroup({});
  code:string="+91";
  orderid:string="(place order to recieve order number via Subject)";
  constructor(private userService: UserService,private fb:FormBuilder) {}

  ngOnInit(): void {
    this.loading = true;
    this.userService.getAll().pipe(first()).subscribe(users => {
      this.loading = false;
      this.users = users;
    });
    
    this.signupForm  = this.fb.group({
      email: ['',[Validators.required,
      Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      phone: ['', [Validators.required, Validators.pattern("^((\\+[0-9][0-9]-?)|\\+[1])?[0-9]{10}$")]],
      required: ['', [Validators.required]]
    
    })



  }
  //Generate ORDER ID using subject
subjectdemo(event)
{

  if(this.signupForm.valid) {
    console.log("***** SUBJECT working  DEMO *****")
    const subject=new Subject();
    const obs=subject.asObservable();
    obs.subscribe(data=>console.log("orderid: "+data))
    this.orderid="OD"+Math.random().toString()
    this.orderid=this.orderid.substring(0,2)+this.orderid.substring(4,this.orderid.length)
    subject.next(this.orderid)
  }
  else{
    //Error Handeling demo
    alert("Please fill all the required fields and try again");
    
    throw new Error('Im error');
    
  }

 
   
}
  //2 way data binding bwtween country and phone:
  //WHen you select a country the phone fields prfix will be automatically updated
  //UPDATE is displayed when selecting country then clicking on phone text box
  public onOptionsSelected(event) {
    const value = event.target.value;
  
    this.selected = value;
    console.log("DROPDOWN VALUE: "+value);
    if(this.selected=="USA")
    {
      this.code="+1"
    }
    if(this.selected=="UK")
    {
      this.code="+44"
    }
    if(this.selected=="IND")
    {
      this.code="+91"
    }
 }

 public onClick(event)
 {
   const value:string = event.target.value;
  
   console.log("Button VALUE: "+value); 
   let index:number=Number(value[0]);
   console.log("INDEX VALUE: "+index);
   if(value.endsWith('+'))
   {
     this.qty[index]++
     this.cost[index]=this.itemcost[index]*this.qty[index];

   }
   if(value.endsWith('-'))
   {
     if(this.qty[index]>0)
     {
     this.qty[index]--;
     this.cost[index]=this.itemcost[index]*this.qty[index];
     }

   }
   this.finalcost=0;
   this.cost.forEach(n=>this.finalcost=n+this.finalcost)
   this.tax=this.finalcost*2.0/100
   this.subtotal=this.finalcost+this.tax

   
 }

 get email() { return this.signupForm.get('email'); }
 get required() { return this.signupForm.get('required'); }
 get phone() { return this.signupForm.get('phone'); }

}


